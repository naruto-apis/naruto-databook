# Naruto API - Databooks

This API provides data regarding each character's stats, based on the official databooks released by Masashi Kishimoto.


## Endpoints

#### GET /api/v1/

Returns all existing characters and their databook stats. 


| parameter       | default value | description                                     |
|-----------------|---------------|-------------------------------------------------|
| databookversion | 0             | filter by databook version; 0 means no filter   |

> GET /api/v1?databookversion=1

```json
[ 
  {
    "name": "Naruto",
    "databooks": [{
        "version": 1,
        "statsList": [
          { "name": "NINJUTSU", "value": 1.0 },
          { "name": "GENJUTSU", "value": 0.0 },
          { "name": "TAIJUTSU", "value": 3.0 }
        ]
    }]
  },  
  {
    "name": "Sasuke",
    "databooks": [{
      "version": 1,
      "statsList": [
        { "name": "NINJUTSU", "value": 3.0 },
        { "name": "GENJUTSU", "value": 2.0 },
        { "name": "TAIJUTSU", "value": 4.0 }
      ]
    }]
  }
]
```

#### GET /api/v1/{characterName}

Returns all existing stats about one specific character. 

| parameter       | default value | description                                     |
|-----------------|---------------|-------------------------------------------------|
| databookversion | 0             | filter by databook version; 0 means no filter   |
| ignorecase      | true          | ignores case when querying for character's name |

> GET /api/v1/Naruto?ignorecase=false&databookversion=2

```json
[{
    "name": "Naruto",
    "databooks": [{
        "version": 2,
        "statsList": [
          { "name": "NINJUTSU", "value": 5.0 },
          { "name": "GENJUTSU", "value": 1.0 },
          { "name": "TAIJUTSU", "value": 5.0 }
        ]
    }]
}]
```

#### POST /api/v1/

Used to create a new character and insert it into the database. It receives a character as request body parameter, example show below:

```json
{
    "name": "string",
    "databooks": [{
        "version": "int",
        "statsList": [
          { "name": "StatsEnum", "value": "double" },
          { "name": "StatsEnum", "value": "double" },
          { "name": "StatsEnum", "value": "double" }
        ]
    }]
}
```

#### PUT /api/v1/

Used to update an existing character in the database. All information of the existing character is replaced by what is sent via request body parameter, example show below:

```json
{
    "name": "string",
    "databooks": [{
        "version": "int",
        "statsList": [
          { "name": "StatsEnum", "value": "double" },
          { "name": "StatsEnum", "value": "double" },
          { "name": "StatsEnum", "value": "double" }
        ]
    }]
}
```


