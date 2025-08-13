<h2>Documentación de la API Rest - Proyecto Foro Hub Backend</h2>

Rutas:

<h2>POST /login</h2>
Bearer Token: NO REQUERIDO

Obtiene token JWT, requerido para todas las demas rutas.

Body:

{
	"login": "xxx@xxx.com",     //REQUERIDO
	"password": "xxxxxxxxx"     //REQUERIDO
}


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
	"titulo": "Consulta",               //REQUERIDO
	"mensaje": "como instalo NPM",      //REQUERIDO
	"curso": "NODEJS"                   //REQUERIDO
	}


<h2>PUT /topicos/n</h2>
Bearer Token: REQUERIDO

Modifica el tópico con Id = n

Body:
{
	"titulo": "Consulta",               //OPCIONAL\n
	"mensaje": "como instalo NPM",      //OPCIONAL
	"curso": "NODEJS"                   //OPCIONAL
	}


<h2>POST /topicos/n/respuestas</h2>
Bearer Token: REQUERIDO

Crea nueva respuesta para el tópico de Id = n

Body:
{
	"mensaje": "como instalo NPM",      //REQUERIDO
	}


<h2>GET /topicos/n/respuestas</h2>
Bearer Token: REQUERIDO

Lista todas las respuestas del tópico de Id = n
