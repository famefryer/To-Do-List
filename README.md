# Restful API for To-Do List Application
## By Java Spring Boot
### todo.save
Description : Save new to-do  
Method : Post  
URI : /todo  
Content-Type : application/json 
##### Request-Header  
Parameter | Type | Description  
--- | --- | --- 
 - | - | -
##### Request-Body  
Parameter | Type | Description  
--- | --- | --- 
 name | String | Name of the task
 description | String | Description of the task
 
##### Response-Header  
Parameter | Type | Description  
--- | --- | --- 
 - | - | -T
##### Response-Body  
Parameter | Type | Description  
--- | --- | --- 
 code | int | Http code
 message | String | Short description from the server  
 result | Object | Show result: Saved task
   
   ---
 ### todo.update
 Description : Updatye todo by ID  
 Method : Put  
 URI : /todo/{id}  
 Content-Type : application/json 
 ##### Request-Header  
 Parameter | Type | Description  
 --- | --- | --- 
  - | - | -
 ##### Request-Body  
 Parameter | Type | Description  
 --- | --- | --- 
  name | String | Name of the task
  description | String | Description of the task
  
 ##### Response-Header  
 Parameter | Type | Description  
 --- | --- | --- 
  - | - | -
 ##### Response-Body  
 Parameter | Type | Description  
 --- | --- | --- 
code | int | Http code
message | String | Short explanation from the server
result | Object | Show result: Updated task  
    
   ---
 ### todo.delete
 Description : Delete todo by ID  
 Method : Delete  
 URI : /todo/{id}  
 Content-Type : application/json 
 ##### Request-Header  
 Parameter | Type | Description  
 --- | --- | --- 
  - | - | -
 ##### Request-Body  
 Parameter | Type | Description  
 --- | --- | --- 
 - | - | -
  
 ##### Response-Header  
 Parameter | Type | Description  
 --- | --- | --- 
  - | - | -
 ##### Response-Body  
 Parameter | Type | Description  
 --- | --- | --- 
  code | int | Http code
  message | String | Short explanation from the server
  
   ---
 ### todo.getToDoList
 Description : list all To-Do  
 Method : Get  
 URI : /todo  
 Content-Type : application/json 
 ##### Request-Header  
 Parameter | Type | Description  
 --- | --- | --- 
  - | - | -
 ##### Request-Body  
 Parameter | Type | Description  
 --- | --- | --- 
- | - | -
  
 ##### Response-Header  
 Parameter | Type | Description  
 --- | --- | --- 
  - | - | -
 ##### Response-Body  
 Parameter | Type | Description  
 --- | --- | --- 
  code | int | Http code
  message | String | Short explanation from the server
  result | Object | Show result: List of all To-Do tasks
  
   ---
 ### todo.findToDoByID
 Description : Find todo by ID  
 Method : Get  
 URI : /todo/{id}  
 Content-Type : application/json 
 ##### Request-Header  
 Parameter | Type | Description  
 --- | --- | --- 
  - | - | -
 ##### Request-Body  
 Parameter | Type | Description  
 --- | --- | --- 
 - | -| -
  
 ##### Response-Header  
 Parameter | Type | Description  
 --- | --- | --- 
  - | - | -
 ##### Response-Body  
 Parameter | Type | Description  
 --- | --- | --- 
  code | int | Http code
  message | String | Short explanation from the server
  result | Object | Show result: To-Do task
  
 



