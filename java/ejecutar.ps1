# Ejecuta las demos GRASP.
# Uso:  .\ejecutar.ps1            -> los 9 patrones
#       .\ejecutar.ps1 3          -> solo el patrón 3
#       .\ejecutar.ps1 experto    -> solo Experto en Información
Set-Location $PSScriptRoot

# El acento se ve bien solo si la consola está en UTF-8:
chcp 65001 > $null
$OutputEncoding = [System.Text.Encoding]::UTF8

if (-not (Test-Path out)) { & "$PSScriptRoot\compilar.ps1" }

java "-Dstdout.encoding=UTF-8" -cp out grasp.Main $args
