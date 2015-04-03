#!/usr/bin/env python3
#coding:utf-8

import cgi
import athletemodel
import yate

#import cgitb
#cgitb.enable()

form_data = cgi.FieldStorage()
athlete_name = form_data['which_athlete'].value
athletes_time = athletemodel.get_from_store()

print(yate.start_response())
print(yate.include_header("Coach Kelly's Timing Data"))
print(yate.header("Athlete: " + athlete_name + ", DOB: " + athletes_time[athlete_name].dob + "."))
print(yate.para("The top times for this athlete are: "))
print(yate.u_list(athletes_time[athlete_name].top3))
print(yate.include_footer({ "Home" : "/index.html",
							"Select another athlete" : "generate_list.py"}))
