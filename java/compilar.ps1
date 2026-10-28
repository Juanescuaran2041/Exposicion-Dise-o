# Compila los 9 paquetes GRASP en la carpeta out/
# Uso:  .\compilar.ps1
$ErrorActionPreference = "Stop"
Set-Location $PSScriptRoot

$fuentes = Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName }
Write-Host "Compilando $($fuentes.Count) archivos .java ..."

javac -encoding UTF-8 -d out $fuentes
if ($LASTEXITCODE -eq 0) { Write-Host "Listo. Ejecuta:  .\ejecutar.ps1" -ForegroundColor Green }
