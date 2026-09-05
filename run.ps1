# Script para descargar Maven y ejecutar la aplicación

$mavenVersion = "3.8.1"
$mavenUrl = "https://archive.apache.org/dist/maven/maven-3/$mavenVersion/apache-maven-$mavenVersion-bin.zip"
$mavenHome = "$env:USERPROFILE\.maven\apache-maven-$mavenVersion"
$mavenZip = "$env:USERPROFILE\.maven\apache-maven-$mavenVersion-bin.zip"

# Crear directorio si no existe
if (-not (Test-Path "$env:USERPROFILE\.maven")) {
    New-Item -ItemType Directory -Path "$env:USERPROFILE\.maven" | Out-Null
}

# Descargar Maven si no existe
if (-not (Test-Path $mavenHome)) {
    Write-Host "Descargando Maven $mavenVersion..." -ForegroundColor Green
    try {
        # Intentar con curl primero
        curl -L -o $mavenZip $mavenUrl
    }
    catch {
        Write-Host "curl falló, intentando con WebClient..." -ForegroundColor Yellow
        $client = New-Object System.Net.ServicePointManager
        [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.SecurityProtocolType]::Tls12

        $web = New-Object System.Net.WebClient
        $web.DownloadFile($mavenUrl, $mavenZip)
    }

    if (Test-Path $mavenZip) {
        Write-Host "Extrayendo Maven..." -ForegroundColor Green
        Expand-Archive -Path $mavenZip -DestinationPath "$env:USERPROFILE\.maven" -Force
        Remove-Item $mavenZip
    }
    else {
        Write-Host "Error: No se pudo descargar Maven" -ForegroundColor Red
        exit 1
    }
}

# Ejecutar Maven
Write-Host "Ejecutando aplicación en puerto 8081..." -ForegroundColor Green
$env:PATH = "$mavenHome\bin;$env:PATH"
& mvn clean spring-boot:run

