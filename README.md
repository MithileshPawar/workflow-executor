# workflow-executor
Workflow executor service

## Build and Run Project

```
workflow-executor> .\mvnw clean install

```

## Prerequisites
Java 21 or higher
Maven 3.8+


## API Endpoints

<details>
 <summary><code>GET</code><code>/workflows/{id}</code></summary>

##### Description

Gets workflow details using workflow id.

##### Auth

Basic Authentication: Username & Password

##### Parameters

> | name        |  type     | data type      | description |
> |-------------|-----------|----------------|-------------|
> | `id`         |  required | int   | Workflow Id |


##### Responses

> | http code     | content-type                      | 
> |---------------|-----------------------------------|
> | `200`         | `application/json`                | 

##### Sample Response
```json
{
  "createdAt": "2026-01-26T18:24:22.732784",
  "id": 1,
  "status": "PENDING"
}
```

##### Example cURL

> ```javascript
>  curl http://localhost:8080/workflows/1
> ```

</details>

<details>
 <summary><code>GET</code> <code>/workflows</code></summary>

##### Description

Get all workflows

##### Auth

Basic Authentication: Username & Password

##### Responses

> | http code     | content-type                      | 
> |---------------|-----------------------------------|
> | `200`         | `application/json`                | 

##### Sample Response
```json
[
  {
    "createdAt": "2026-01-26T18:24:22.732784",
    "id": 1,
    "status": "PENDING"
  }
]
```

##### Example cURL

> ```javascript
>  curl http://localhost:8080/workflows
> ```

</details>

<details>
 <summary><code>POST</code> <code>/workflows</code></summary>

##### Description

Submit a workflow for processing
##### Parameters

> | name         |  type     | data type      | description                  |
> |--------------|-----------|----------------|------------------------------|
> | `name`       |  required | string         | Name of workflow             |
> | `steps`      |  required | array of strings | Desired steps in workflow    |
> | `parameters` |  required | key-value pair | Key Value pair of parameters |

##### Sample Request
```json
{
  "name": "workflow2",
  "steps": [
    "s1",
    "s2"
  ],
  "parameters": {
    "param1": "p1"
  }
}
```

##### Responses

> | http code     | content-type                      | 
> |---------------|-----------------------------------|
> | `200`         | `application/json`                | 

##### Sample Response
```json
{
  "createdAt": "2026-01-26T18:24:22.732784",
  "id": 1,
  "status": "PENDING"
}
```

##### Example cURL

> ```javascript
>  curl http://localhost:8080/workflows
> ```

</details>
