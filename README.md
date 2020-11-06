# GidAssistant Server application
**Base url: https://gidassistant.herokuapp.com/**

# User registration
### 1. For creating new user use this url, with method **_POST_**
` https://gidassistant.herokuapp.com/user/register `
 
 
**1.1 User data for register**
 
|   Param name   |     Data type  |      Example        |  Needed  |
|----------------|----------------|---------------------|----------|
|     "name"     |      String    |       "Yuriy"       |   Yes    |
|    "passwd"    |      String    |      "3AJd4k"       |   Yes    |
|   "birthday"   |       Long     |    1215005451215    |   Yes    |
|     "login"    |      String    |       "Yuriy"       |   Yes    |
|     "email"    |      String    |       "Yuriy"       | Optional |
|     "city"     |       City     |                     | Optional |
|   "interests"  | List<Interest> |                     | Optional |
|      "ip"      |      String    |    "192.168.0.1"    |   Yes    |
|    "macAddr"   |      String    | "00-26-DD-14-C4-EE" |   Yes    |
|   "phoneData"  |      String    |       "Yuriy"       |   Yes    |
 
**1.2 City fields for creating**
 
|   Param name   |     Data type  |      Example        |  Needed  |
|----------------|----------------|---------------------|----------|
|     "name"     |      String    |      "Odessa"       |   Yes    |
|   "latitude"   |      Double    |       46.4775       |   Yes    |
|   "longitude"  |      Double    |       30.7326       |   Yes    |
|   "googleUrl"  |      String    |       "Yuriy"       |   Yes    |
|     "type"     |      String    |    big/town/small   | Optional |

**1.3 Interests fields for creating**
 
|   Param name   |     Data type  |      Example        |  Needed  |
|----------------|----------------|---------------------|----------|
|     "name"     |      String    |      "Movie"       |   Yes    |

**1.4 _Example of JSON-request_**

 `
 
    "name":"Your name",
    "passwd":"Your password",
    "birthday":10398129319012,
    "login":"Your login" (optional),
    "email":"Your@email.example",
    
    "city": {
        "name":"City name",
        "latitude":46.4775,
        "longitude":30.7326,
        "googleUrl":"Your city GoogleMaps url",
        "type":"big" (small/town)
    },
    
    "interests":[
        {
            "name":"Interest name"
        }
    ],
    
    "ip":"Your IP address",
    "macAddr":"Your MAC-addr",
    "phoneData":"Your phone name" 
    
`

# User login
### 1. For login user you must use this url, with method **_POST_**
` https://gidassistant.herokuapp.com/user/login `

Json-file must contains next params

`

    "serverId":"your user ID obtained during registration", (example: 76f940d2-a2ac-46e3-b4f9-8ce095c158bb)
    "ip":"your device IP address",
    "macAddr":"your device MAC address"

`

# User logout
### 1. There are 2 types of login**
**All of these must be call this URL with method _DELETE_**
` https://gidassistant.herokuapp.com/user/logout `

**1.1 Logout only from current phone**

Example of JSON request

` "sessionId":"63562db4-20b9-43dd-b1c1-e4f028453940" `

**1.2 Logout from all phones**

Example of JSON request

` "userId":"76f940d2-a2ac-46e3-b4f9-8ce095c158bb" `
