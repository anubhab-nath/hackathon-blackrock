$APP_NAME="blk-hacking-ind-anubhab-nath"
$IMAGE_NAME="springboot-app:latest"
$PORT=8080

Write-Host "Building Gradle project..."
./gradlew clean build -x test

if ($LASTEXITCODE -ne 0) {
    Write-Host "Gradle build failed"
    exit 1
}

Write-Host "Building Docker image..."
docker build -t $IMAGE_NAME .

Write-Host "Stopping old container..."
docker rm -f $APP_NAME 2>$null

Write-Host "Starting new container..."
docker run -d `
  --name $APP_NAME `
  -p $PORT:$PORT `
  $IMAGE_NAME

Write-Host "Deployment complete!"
Write-Host "App running at http://localhost:$PORT"