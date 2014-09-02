# clj-fleet

A wrapper for the CoreOS [fleet API][fleet-api].

## Usage

The API is versioned.  Currently `v1-alpha` is supported.

```clj
(require '[com.palletops.fleet.v1-alpha :as fleet])
```

To use the API you will need to create a connection map.  This
requires the fleet endpoint to be exposed on a TCP port (see the
[fleet API docs][fleet-api] for how to achieve that).

```clj
(fleet/connect "http://localhost:4244")
```

The api provides the following functions, each of which take the
connection map as the first argument, any mandatory parameters,
followed by an options map.

`machine-list`, `unit-list`, `unit-get`, `unit-delete`, `unit-set`,
`unit-state-list`.

Each function returns a promise, and takes an optional callback as its
last argument, much like the http-kit client.

## License

Copyright © 2014 Hugo Duncan

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[fleet-api]:https://github.com/coreos/fleet/blob/master/Documentation/api-v1-alpha.md "CoreOS Fleet API"
