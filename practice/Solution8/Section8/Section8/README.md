# ContActivist README

Download the eclipse project (including the web demo) [here](https://github.com/brahmcapoor/CS106-teaching-materials/raw/master/CS106A/ContActivist/download.zip)

## Summary

This is a program based on the section 9 handout of CS 106A Winter Quarter 2018 at Stanford University. The genuinely important things are as follows:

* `ContActivistClient.java`: a fully featured client
* `ContActivistServer.java`: a server that students need to implement
* `CongressMember.java`: a class representing a Congress Member that students need to implement.
* `ContActivistServerSoln.java`: solution code for the server (to be posted after I teach section)
* `CongressMemberSolution.java` solution code for the Congress Member class (to be posted after I teach section)

The `webpage` directory has resources for a web client to show students for fun. At this point, I can't think of anything else that might be important but this document will be updated as necessary. 

## How to use the web demo

1) Download the Eclipse project from this repo (see the link at the top of this document) and import it as you normally would.
2) Run `ContActivistServer.java` or `ContActivistServerSoln.java` from Eclipse, making sure that `private static final int PORT = 8000;`
3) Open `webpage/index.html` in your browser or -- if you're comfortable doing so -- run `python -m SimpleHTTPServer 8080` and naivgate to `localhost:8080` in your browser. As far as I've tested, there isn't much of a difference between the two but the latter makes you seem like more of a hacker.
4) The demo should just work now. If anything weird comes up, shoot me an email at brahm@stanford.edu. 

## To students:

**NOTE**: I _strongly_ recommend you try implementing these programs yourself before looking at the solutions. For what it's worth, they're great exam practice!

Open up `ContActivistServer.java` and try to implement the server, based on the section handout and the comments in the starter code. Try to implement the server. As you're doing so, you might find it helpful (hint hint!) to implement a class representing a Congress Member. Do so in `CongressMember.java`. As you're working, you might find it helpful to test your program using `ContActivistClient.java`. It's also a good idea to poke around that program to get some idea of how requests are made. 

—————————————————————

# FlightPlanner README

Download the eclipse project (including the web demo) [here](https://github.com/brahmcapoor/CS106-teaching-materials/raw/master/CS106A/FlightPlanner/download.zip)

## Summary

This is a program based on the section 8 handout of CS 106A Winter Quarter 2018 at Stanford University. The genuinely important things are as follows:

* `FlightPlannerClient.java`: a fully featured client
* `FlightPlannerServer.java`: a server that students need to implement
* `FlightPlannerServerSoln.java`: solution code for the server (to be posted after I teach section)

The `webpage` directory has resources for a web client to show students for fun. At this point, I can't think of anything else that might be important but this document will be uploaded as necessary. 

## How to use the web demo

_Note: A previous version of this readme instructed you to install a CORS extension for Chrome and/or firefox. You no longer need to do this, since CORS is now enabled in `SimpleServer.jar`._

1) Download the Eclipse project from this repo (see the link at the top of this document) and import it as you normally would.
2) Run `FlightPlannerServer.java` or `FlightPlannerServerSoln.java` from Eclipse, making sure that `private static final int PORT = 8080;`
3) Open `webpage/index.html` in your browser.
4) The demo should just work now. If anything weird comes up, shoot me an email at brahm@stanford.edu.


