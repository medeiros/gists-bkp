# gists-bkp

[![CircleCI](https://img.shields.io/circleci/build/github/medeiros/gists-bkp/master)](https://circleci.com/gh/medeiros/gists-bkp)
[![Code Size](https://img.shields.io/github/languages/code-size/medeiros/gists-bkp)](https://img.shields.io/github/languages/code-size/medeiros/gists-bkp)
[![License](https://img.shields.io/github/license/medeiros/gists-bkp)](https://img.shields.io/github/license/medeiros/gists-bkp)


A Clojure library designed to backup Github gists.

## Usage

In the repl:

	$ lein repl
	user=> (use 'gists-bkp.core)
	user=> (get-gists-pull-url) ; data will be saved into 'gist-clones' dir

To run unit tests:

	$ lein test


## License

Copyright © 2019 FIXME

Distributed under the MIT License.
