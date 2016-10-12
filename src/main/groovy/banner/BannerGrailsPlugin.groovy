package banner

import grails.plugins.*
import grails.util.Environment

class BannerGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.0.0 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Banner Plugin" // Headline display name of the plugin
    def author = "Joe McCall"
    def authorEmail = "joe@mccall.email"
    def description = '''\
Displays a small banner upon application startup showing app name, version, and data source details. Useful for
knowing at a quick glance if you're connecting to the right database, or even if you feel a bit nostalgic from the
platform-core plugin.

Heavliy inspired by the data-dump feature of the platform-core plugin from Grails 2.x from Grailsrocks. It can be found at
https://github.com/grails-plugins/grails-platform-core. The main difference between that code and this is that it is
updated to read from the config object correctly.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/banner"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
   def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
//    def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]

    // Online location of the plugin's browseable source code.
//    def scm = [ url: "http://svn.codehaus.org/grails-plugins/" ]


    Closure doWithSpring() { {->
        }
    }

    void doWithDynamicMethods() {
        // TODO Implement registering dynamic methods to classes (optional)
    }

    void doWithApplicationContext() {
        // TODO Implement post initialization spring config (optional)

        applicationStartupInfo()
    }

    void onChange(Map<String, Object> event) {
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    void onConfigChange(Map<String, Object> event) {
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    void onShutdown(Map<String, Object> event) {
        // TODO Implement code that is executed when the application shuts down (optional)
    }

    void applicationStartupInfo() {
        // TODO
//        if (pluginConfig?.show.startup.info) {
        def w = 70
        println '='*w
        def name = grailsApplication.metadata.'info.app.name'
        def ver = grailsApplication.metadata.'info.app.version'
        def welcome = "Application: "+(ver ? "$name $ver" : name)

        println ''
        println welcome.center(w)
        println(('-'*welcome.length()).center(w))
        println ''
        println "  Environment: ${Environment.current}"
        println '  Database configuration: '
        def ds = grailsApplication.config.dataSource

        def ddlMode, jndiName, hibernateUrl, hibernateDriver, hibernateUser
        grailsApplication.metadata
        grailsApplication.config.with {
            ddlMode = getProperty('dataSource.dbCreate')
            jndiName = getProperty('dataSource.jndiName')
            hibernateUrl = getProperty('dataSource.url')
            hibernateDriver = getProperty('dataSource.driverClassName')
            hibernateUser = getProperty('dataSource.username')
        }

        println "    Hibernate DDL mode: ${ddlMode}"
        if (jndiName) {
            println "    JNDI: ${jndiName}"
        } else {
            println "    URL: ${hibernateUrl}"
            println "    Driver: ${hibernateDriver}"
            println "    User: ${hibernateUser}"
        }

        println '='*w
//        }
    }
}
