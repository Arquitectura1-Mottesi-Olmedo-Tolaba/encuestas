package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.OptionCounter;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Statistic;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Subject;

@Transactional
@Service
public class StatisticsFactoryService {

	@Autowired
	private StatisticService statisticService;

	public void initialize(String nameDegree, List<Subject> basicMaterias) {
			
		//PREPARAR STATS PARA MATERIAS BASICAS...
		
		Subject lectura = new Subject("Lectura y escritura académica");
		
		OptionCounter laquisieraLectura = new OptionCounter("la quisiera cursar...",23);
		OptionCounter comision1Lectura = new OptionCounter("Comision 1",13,60);

		Statistic statLectura = statisticService.newStatistic(lectura,
				Arrays.asList(comision1Lectura,laquisieraLectura));
		statisticService.save(statLectura);
		/*
		{
            "id": 1,
            "name": "Lectura y escritura académica",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 13,
                    "amount": 60
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 23
                }
            ]
        },
		*/
		
		Subject mate = new Subject("Matemática");
		
		OptionCounter laquisieraMate =  new OptionCounter("la quisiera cursar...",372);
		OptionCounter comision1Mate =	new OptionCounter("Comision 1",8,11);

		Statistic statMate = statisticService.newStatistic(mate,
				Arrays.asList(comision1Mate,laquisieraMate));
		
		statisticService.save(statMate);
		
		/*
		
        {
            "id": 2,
            "name": "Matemática",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 8,
                    "amount": 11
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 372
                }
            ]
        },
        */
		Subject elementos = new Subject("Elementos de programación y lógica");
		
		OptionCounter comision1Elementos = new OptionCounter("Comision 1",
				91,55);
		OptionCounter laquisieraElementos = new OptionCounter("la quisiera cursar...",274);

		Statistic statElementos = statisticService.newStatistic(elementos,
				Arrays.asList(comision1Elementos,laquisieraElementos));
		
		statisticService.save(statElementos);
		/*
        {
            "id": 3,
            "name": "Elementos de programación y lógica",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 91,
                    "amount": 55
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 274
                }
            ]
        },
        

        {
            "id": 4,
            "name": "Introducción a la Programación",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 70,
                    "amount": 54
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 368
                }
            ]
        },
        {
            "id": 5,
            "name": "Organización de Computadoras",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 68,
                    "amount": 22
                },
                {
                    "name": "Comision 2",
                    "capacity": 91,
                    "amount": 39
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 187
                }
            ]
        },
        {
            "id": 6,
            "name": "Matemática I",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 93,
                    "amount": 55
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 137
                }
            ]
        },
        */
		
		Subject objetos1 = new Subject("Programación con Objetos I");
		
		OptionCounter comision1Objetos1  = new OptionCounter("Comision 1",
				28,10);
		OptionCounter laquisieraObjetos1 = new OptionCounter("la quisiera cursar...",376);

		Statistic statObjetos1 = statisticService.newStatistic(objetos1,
				Arrays.asList(comision1Objetos1,laquisieraObjetos1));
		
		statisticService.save(statObjetos1);
        /*
		{
            "id": 7,
            "name": "Programación con Objetos I",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 28,
                    "amount": 10
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 376
                }
            ]
        },
        */
		Subject bases = new Subject( "Bases de Datos");
		
		OptionCounter comision1Bases  = new OptionCounter("Comision 1",
				43,14);
		OptionCounter comision2Bases  = new OptionCounter("Comision 2",
				66,8);
		OptionCounter laquisieraBases = new OptionCounter("la quisiera cursar...",259);

		Statistic statBases = statisticService.newStatistic(bases,
				Arrays.asList(comision1Bases,comision2Bases, laquisieraBases));
		
		statisticService.save(statBases);
		/*
        {
            "id": 8,
            "name": "Bases de Datos",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 43,
                    "amount": 14
                },
                {
                    "name": "Comision 2",
                    "capacity": 66,
                    "amount": 8
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 259
                }
            ]
        },
        */
		Subject estD = new Subject("Estructuras de Datos");
		
		OptionCounter comision1Est  = new OptionCounter("Comision 1",
				6,39);
		OptionCounter laquisieraEst = new OptionCounter("la quisiera cursar...",147);

		Statistic statEst = statisticService.newStatistic(estD,
				Arrays.asList(comision1Est, laquisieraEst));
		
		statisticService.save(statEst);

		/*
        {
            "id": 9,
            "name": "Estructuras de Datos",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 6,
                    "amount": 39
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 147
                }
            ]
        },
        */
		Subject objetos2 = new Subject("Programación con Objetos II");
		
		OptionCounter comision1Obj2  = new OptionCounter("Comision 1",
				5,37);
		OptionCounter laquisieraObj2 = new OptionCounter("la quisiera cursar...",361);

		Statistic statObj2 = statisticService.newStatistic(objetos2,
				Arrays.asList(comision1Obj2, laquisieraObj2));
		
		statisticService.save(statObj2);
		/*
        {
            "id": 10,
            "name": "Programación con Objetos II",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 5,
                    "amount": 37
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 361
                }
            ]
        },
        */
		Subject redes = new Subject("Redes de Computadoras");
		
		OptionCounter comision1Redes  = new OptionCounter("Comision 1",
				28,63);
		OptionCounter comision2Redes  = new OptionCounter("Comision 2",
				87,30);
		OptionCounter laquisieraRedes = new OptionCounter("la quisiera cursar...",48);

		Statistic statRedes = statisticService.newStatistic(redes,
				Arrays.asList(comision1Redes,comision2Redes, laquisieraRedes));
		
		statisticService.save(statRedes);
		/*
        {
            "id": 11,
            "name": "Redes de Computadoras",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 28,
                    "amount": 63
                },
                {
                    "name": "Comision 2",
                    "capacity": 87,
                    "amount": 30
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 48
                }
            ]
        },
        */
		Subject so = new Subject("Sistemas Operativos");
		
		OptionCounter comision1So  = new OptionCounter("Comision 1",
				95,62);
		OptionCounter laquisieraSo = new OptionCounter("la quisiera cursar...",40);

		Statistic statSo = statisticService.newStatistic(so,
				Arrays.asList(comision1So, laquisieraSo));
		
		statisticService.save(statSo);
		/*
        {
            "id": 12,
            "name": "Sistemas Operativos",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 95,
                    "amount": 62
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 40
                }
            ]
        },
        */
		Subject pconc = new Subject("Programación Concurrente");
		
		OptionCounter comision1Conc  = new OptionCounter("Comision 1",
				18,40);
		OptionCounter comision2Conc  = new OptionCounter("Comision 2",
				71,68);
		OptionCounter laquisieraConc = new OptionCounter("la quisiera cursar...",290);

		Statistic statConc = statisticService.newStatistic(pconc,
				Arrays.asList(comision1Conc,comision2Conc, laquisieraConc));
		
		statisticService.save(statConc);

		/*
        {
            "id": 13,
            "name": "Programación Concurrente",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 18,
                    "amount": 40
                },
                {
                    "name": "Comision 2",
                    "capacity": 71,
                    "amount": 68
                },
                {
                    "name": "la quisiera cursar...",
          Subject mate2 = new Subject("Matemática II");
		
		OptionCounter comision1Bases  = new OptionCounter("Comision 1",
				43,14);
		OptionCounter comision2Bases  = new OptionCounter("Comision 2",
				66,8);
		OptionCounter laquisieraBases = new OptionCounter("la quisiera cursar...",259);

		Statistic statBases = statisticService.newStatistic(bases,
				Arrays.asList(comision1Bases,comision2Bases, laquisieraBases));
		/*
        {
            "id": 14,
            "name": "Matemática II",
            "info": [
                {
                    "name": "Comision 1",
                    "capacity": 63,
                    "amount": 52
                },
                {
                    "name": "Comision 2",
                    "capacity": 50,
                    "amount": 26
                },
                {
                    "name": "la quisiera cursar...",
                    "amount": 257
                }
            ]
        },
        */
		
	}
	
	

}
