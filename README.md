<h2>How to make a build</h2>

docker build -t carrental:v1 .

<h2>Run the image in a docker container.</h2>

docker run -p 8080:8080 carrental:v1

<h2>How to check the ip address of the docker container.</h2>
docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' container_name_or_id