BROWSER=$1
HEADLESS=$2
TAGNAME=$3
REMOTEURL=$4
NODECOUNT=$5
WORKSPACE=$6
timeout=40
start_time=$(date +%s)

echo "browser: ${BROWSER}"
echo "tag: ${TAGNAME}"
echo "headless: ${HEADLESS}"
echo "remoteurl: ${REMOTEURL}"

network_name="insider-network"

echo "------------------------create network-----------------------------------------------"
if ! docker network ls | grep -q "$network_name"; then
    echo "Network '$network_name' does not exist. Creating..."
    docker network create "$network_name"
    echo "Network '$network_name' created successfully!"
else
    echo "Network '$network_name' already exists."
fi
echo "------------------------docker compose up--------------------------------------------"
docker-compose up -d
echo "Waiting for the Grid"
while ! curl -sSL "http://localhost:4444/status" 2>&1 |
  jq -r '.value.ready' 2>&1 | grep "true" >/dev/null; do
  printf '.'
  sleep 1
  current_time=$(date +%s)
  elapsed_time=$((current_time - start_time))
  if [ $elapsed_time -ge $timeout ]; then
    echo -e "\nTimeout while waiting for the Grid."
    exit 1
  fi
done
echo "Grid is ready!"
echo "--------------------------creating docker image---------------------------------------"
docker build -q -t projectimage .
echo "------------------docker create container----------------------------------------------"
docker run --rm -v ${WORKSPACE}/allure-results:/app/allure-results --network=$network_name projectimage mvn clean test -Dtest=Runner -Dbrowser=${BROWSER} -Dheadless=${HEADLESS} -D"cucumber.filter.tags=${TAGNAME}" -DremoteUrl=${REMOTEURL} -DthreadCount=${NODECOUNT}
docker-compose down