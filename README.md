Configuration Management Pivot
------------------------------

    environments/

Get list of environments (ex. dev, ci, build, lab, qa, uat, staging, prod, etc)

    environments/${environment}

Gets information about a given environment.

    environments/${environment}/hosts/

Gets list of hosts that are expected to exist in a given environment.

    environments/${environment}/hosts/${host}

Gets information about a given host in a given environment.

    environments/${environment}/hosts/${host}/apps

Gets a list of applications on a given host in a given environment.

    environments/${environment}/hosts/${host}/apps/{$app}

Get information about a given application. `{app}` may be special in that it may be expanded into its own hierarcial structure:

		apps/widgetR/versions/1.0.0-SNAPSHOT/keys/


    environments/${environment}/hosts/${host}/apps/{$app}/keys

Get all configuration keys

    environments/${environment}/hosts/${host}/apps/{$app}/keys/{$key}

Get the value for a given key

    environments/${environment}/hosts/${host}/apps/{$app}/keys-and-values

Get a list of keys and their values paired together (as .properties for example)

    environment/search/${param}
    environment/

    hosts/search/${param}
    hosts/

    apps/search/${param}

    apps/${app}/environments/${environment}

Gets a list of environments that a particular application is present in.

    keys/search/${param}
    keys/

    {ELEMENT}/meta

Lists meta information for any given element member (host/app/environment/etc)

    search/${param}

Search all elements for the given parameter.

    configuration/${payload}

Payload contains:
		Originating Host and IP
		Application Name and Version
		System can infer

Returns:
		Header link-rel URL for retrieving properties as (text/properties, or application/properties).




	* TODO: GETs for above
	* TODO: DELETEs for above
	* TODO: PUTs for above
	* TODO: POSTs for above
	* TODO: Searching in a RESTful manner.
	* TODO: Design/storm common search patterns (ex. all appX in UAT, or all configuration elements matching pattern "db.name")
	* TODO: Backend agnostic? (LDAP, PostgreSQL, MySQL, Neo4J, Spring-data?)
	* TODO: Support COPY between elements (I want to copy appX's configuration in DEV to QA, and then do an update on the resultant COPY in qa/)
	* TODO: Spring App wakes up, sends message to Pivoteer
	* TODO: MimeType for properties?
	* TODO: Target individual bean configurations!


## 1.0:

      -----------------
     |  J2EE container |
     |				   |
     |	 ----------    |
     |   |  .war    |  |
     |    ----------   |
     |                 |
      -----------------
              |
      ------------------
     |     Pivot API    |
      ------------------
          |         |
     ----------   -------
    |   LDAP   | | Neo4j |
     ----------   -------

Pivot API
	- Spring MVC
	- Reasonably REST
	- Simple.
	- JSON/.properties/no xml (yet?).
	- Constructs URLs containing .properties {}
	- Allows for simple adpotion of pivot-api in apps to simply retrieve and store configuration at startup

Pivot AMQP?
	- Spring HTTP Client
	- Sits atop Pivot API
	- Answers simple common payload questions with a URL in a reply-to manner.
	- URL is
	- 2.x: Eventually polls for changes,

Pivot GUI
	- Not sure yet.

    /nodes/list
    /nodes/assignments (which applications are assigned to which modes)
    /apps/assignments
    /apps/${app-name}/configuration
    /apps/${app-name}/dependencies


    .../apps/${app}/notify

Notify a given app that its configuration requires updating

    /events/

Feed for events in reverse chronological order

## 2.0:

     -----------------
    |  J2EE container |
    |				  |
    |	-----------   |
    |  | .war .jmx |  | (JMX Bean)
    |   -----------   | (Listens on a given queue, filters for pertinent messages)
    |                 | (Could reconfigure a specific BEAN's configuration! Per )
     -----------------
 	    |          ^
     	v          |
          [ AMQP ]    (URL(s) In Reply-to for startup)
             ^
             |
             v
     -----------------   -----------
    |   Pivot-AMQP    | | Pivot GUI |
     -----------------   -----------
                 |           |
              ------------------
             |     Pivot API    | REST
              ------------------
               |        |       |
        ----------   -------    -------
       |   LDAP   | | Neo4j |  | JDBC? |
        ----------   -------    -------



beans/${bean-id}