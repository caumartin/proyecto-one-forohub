<h2>Documentación de la API Rest - Proyecto Foro Hub Backend</h2>

<h2>Rutas:</h2>

<h2>POST /login</h2>
Bearer Token: NO REQUERIDO

Obtiene token JWT, requerido para todas las demas rutas.

Body:

{
	"login": "xxx@xxx.com",
	"password": "xxxxxxxxx"
}

<h3>login, password: REQUERIDOS</h3>


<h2>GET /topicos</h2>
Bearer Token: REQUERIDO

Obtiene lista de todos los tópicos


<h2>GET /topicos/n</h2>
Bearer Token: REQUERIDO

Muestra solamente el tópico con Id = n


<h2>POST /topicos</h2>
Bearer Token: REQUERIDO

Crea nuevo tópico

Body:
{
	"titulo": "Consulta",
	"mensaje": "como instalo NPM",
	"curso": "NODEJS"
	}

<h3>titulo, mensaje, curso: REQUERIDOS</h3> 


<h2>PUT /topicos/n</h2>
Bearer Token: REQUERIDO

Modifica el tópico con Id = n

Body:
{
	"titulo": "Consulta",
	"mensaje": "como instalo NPM",
	"curso": "NODEJS"
	}

<h3>titulo, mensaje, curso: OPCIONALES</h3>

<h2>POST /topicos/n/respuestas</h2>
Bearer Token: REQUERIDO

Crea nueva respuesta para el tópico de Id = n

Body:
{
	"mensaje": "como instalo NPM"
	}

<h3>mensaje: REQUERIDO</h3>


<h2>GET /topicos/n/respuestas</h2>
Bearer Token: REQUERIDO

Lista todas las respuestas del tópico de Id = n
