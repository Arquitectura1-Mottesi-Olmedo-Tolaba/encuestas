# ArqSoft-UNQ -s2-2017
Repo para arquitectura de software Mottessi - Olmedo -Tobala

Dentro de backend

# Instalar todo con mvn install
# Levantar server
mvn jetty:run

# Podes acceder a la api en /services/{nombreDelServicio}/...
Por ejemplo  asumiendo que corremos en 8080:

GET -> /services/information/academicOfferInformation/{idDegree} 
	- director current academic offer
	- AcademicOfferStatisticsRest
POST -> /services/directors/login 
	- login
	-DirectorRest
GET -> /services/directors/degreesFor/{id} 
	- degrees para el director
	- DirectorRest
------------------------------------------------------------------------
GET -> /services/students/verify/{code} 
	- verifica la existencia del codigo
	- StudentRest
GET -> /services/students/getSurveyByCode/{code} 
	- trae la oferta para ese codigo
	- StudentRest
POST -> /services/students/save
	- envia la oferta completada por el estudiante
	- StudentRest
------------------------------------------------------------------------
GET -> /services/surveys/codes
	- para ver los codigos de los estudiantes (solo test)
	- SurveyRest
------------------------------------------------------------------------	


BACKEND HEROKU:

https://arq-soft-unq.herokuapp.com/services/users/all

APP frontend: 

arq-front-vue.herokuapp.com

REPO: 

https://github.com/Arquitectura1-Mottesi-Olmedo-Tolaba/arq-front-vue
