# ArqSoft-UNQ -s2-2017
Repo para arquitectura de software Mottessi - Olmedo -Tobala

Dentro de backend

# Instalar todo con mvn install
# Levantar server
mvn jetty:run

# Podes acceder a la api en /services/{nombreDelServicio}/...
Por ejemplo  asumiendo que corremos en 8080:

Si quisiera ver los usuarios registrados podria hacer algo asi...

http://localhost:8080/services/users/all

Funcionalidades muy usadas:

POST : URL + /services/surveys/save para salvar resultados de encuestas.

GET : URL + /services/academicOffers/forStudent/{idStudent} para obtener la oferta academica del estudiante.

GET : URL + /services/directors/{id} para obtener informacion del director conjunto a las carreras.


BACKEND HEROKU:

https://arq-soft-unq.herokuapp.com/services/users/all

APP frontend: 

arq-front-vue.herokuapp.com

REPO: 

https://github.com/Arquitectura1-Mottesi-Olmedo-Tolaba/arq-front-vue
