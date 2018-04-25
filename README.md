# ArqSoft-UNQ -s2-2017
Repo para arquitectura de software Mottessi - Olmedo -Tobala

* Instalar todo con mvn install
* Levantar server

		> mvn jetty:run

# Rest API Director

* GET -> /information/academicOfferInformation/{idDegree}
	- director current academic offer
	- AcademicOfferStatisticsRest

* POST -> /directors/login
	- login
	- DirectorRest

* GET -> /directors/{idDirector}/degrees
	- degrees para el director
	- DirectorRest

# Rest API Survey


* GET -> surveys/verify/{studentSurveyCode}
	- verifica la existencia del codigo
	- SurveyRest

* GET -> /surveys/{studentSurveyCode}
	- trae la oferta para ese codigo
	- SurveyRest

* POST -> /services/surveys
	- envia la oferta completada por el estudiante
	- SurveyRest

# Rest API Student codes

* GET -> /surveys/codes/{idDegree}
	- para ver los codigos de los estudiantes de la carrera pasado como parametro
	- SurveyRest


# Backend:
* https://arq-soft-unq.herokuapp.com
* https://github.com/Arquitectura1-Mottesi-Olmedo-Tolaba/encuestas-backend

# Frontend:
* http://arq-front-vue.herokuapp.com
* https://github.com/Arquitectura1-Mottesi-Olmedo-Tolaba/arq-front-vue
