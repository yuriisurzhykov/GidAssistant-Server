# GidAssistant Server application
**Base url: https://gidassistant.herokuapp.com/**

# User registration
1. For creating new user use this url, with method **_POST_**
` https://gidassistant.herokuapp.com/user/register `

Json-file must contains next params
 
 `
 {
 
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
    "phoneData":"Your phone name" }
  `
