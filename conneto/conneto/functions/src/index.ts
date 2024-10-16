import * as functions from 'firebase-functions';
import * as express from 'express';
import { spawn } from 'child_process';
import * as path from 'path';

// Crear una instancia de express
const app = express();

// Ruta para manejar todas las solicitudes y redirigir al archivo JAR de Spring Boot
app.all('/*', (req, res) => {
    // Ruta absoluta al archivo JAR dentro de la carpeta functions
    const jarPath = path.resolve(__dirname, '../conneto-0.0.1-SNAPSHOT.jar'); // Asegúrate que el nombre del JAR es correcto

    // Iniciar el proceso de Java para ejecutar el archivo JAR
    const child = spawn('java', ['-jar', jarPath]);

    // Capturar y enviar la salida estándar del proceso de Java
    child.stdout.on('data', (data) => {
        res.write(data);
    });

    // Capturar y manejar los errores del proceso de Java
    child.stderr.on('data', (data) => {
        console.error(`stderr: ${data}`);
        res.status(500).send(`Error ejecutando el JAR: ${data}`);
    });

    // Finalizar la respuesta cuando el proceso de Java haya terminado
    child.on('close', (code) => {
        res.end(`El proceso de Java finalizó con código ${code}`);
    });
});

// Exportar la función de Firebase para que maneje las solicitudes HTTP
exports.app = functions.https.onRequest(app);
