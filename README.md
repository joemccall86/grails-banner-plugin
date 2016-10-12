# Grails Banner Plugin
Source code for the grails banner plugin

## Rationale

Our previous Grails 2.x app used the excellent platform-core plugin. Much of its functionality is superceded in the migration to Grails 3, but I was nostalgic for the nice application info banner printed when the app was run.

At first I just copy/pasted the application info dump code from the old platform core plugin and placed it in my own app, but it is really better as a plugin.

## Demo

Before: 

```
$ grails run-app
| Running application...
Grails application running at http://localhost:8080 in environment: development
```

After:

```
$ grails run-app
| Running application...
======================================================================

                    Application: banner-sample 0.1                    
                    ------------------------------                    

  Environment: DEVELOPMENT
  Database configuration: 
    Hibernate DDL mode: create-drop
    URL: jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE
    Driver: org.h2.Driver
    User: sa
======================================================================
Grails application running at http://localhost:8080 in environment: development
```

## Installation

*NOTE* These installation instructions are not yet complete. I still need to publish this plugin to bintray and have it approved by the OCI team to include in the grails plugins portal.

Modify your `build.gradle` file with the following dependency:

```
compile 'org.grails.plugins:banner:0.1'
```

## Also See

http://mrhaki.blogspot.com/2015/04/grails-goodness-add-banner-to-grails.html

This is probably the better way to do this, but plugins only have so much say in what happens. I'm still figuring out if I can hook into the Application class itself to set the banner property.
