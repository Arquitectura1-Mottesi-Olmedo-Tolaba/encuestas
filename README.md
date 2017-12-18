# ArqSoft-UNQ -s2-2017
Repo para arquitectura de software Mottessi - Olmedo -Tobala

* Instalar todo con mvn install
* Levantar server

		> mvn jetty:run

# Rest API Director

* GET -> /services/information/academicOfferInformation/{idDegree}
	- director current academic offer
	- AcademicOfferStatisticsRest

* POST -> /services/directors/login
	- login
	- DirectorRest

* GET -> /services/directors/degreesFor/{idDirector}
	- degrees para el director
	- DirectorRest

# Rest API Studnent

* GET -> /services/students/verify/{studentSurveyCode}
	- verifica la existencia del codigo
	- StudentRest

* GET -> /services/students/getSurveyByCode/{studentSurveyCode}
	- trae la oferta para ese codigo
	- StudentRest

* POST -> /services/students/save
	- envia la oferta completada por el estudiante
	- StudentRest

# Rest API Studnent codes

* GET -> /services/surveys/codes/{idDegree}
	- para ver los codigos de los estudiantes de la carrera pasado como parametro
	- SurveyRest


# Backend:
* https://arq-soft-unq.herokuapp.com
* https://github.com/Arquitectura1-Mottesi-Olmedo-Tolaba/encuestas-backend

# Frontend:
* http://arq-front-vue.herokuapp.com
* https://github.com/Arquitectura1-Mottesi-Olmedo-Tolaba/arq-front-vue
