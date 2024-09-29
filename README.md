# Variance

## Setup
1. Download `data-dependencies` for DAML:
```sh
mkdir -p .lib/daml-ctl/v2.4.1

curl -L https://github.com/digital-asset/daml-ctl/releases/download/v2.4.1/daml-ctl-2.4.1.dar -o .lib/daml-ctl/v2.4.1/daml-ctl-2.4.1.dar
```

## Introduction
This repo explores the relationship between subtyping variance and functorial variance.
- the Java example shows how subtype variance is unsound in Java arrays.
- the Scala example compares subtype and functorial variance since Scala supports both subtype polymorphism as well as ad hoc (typeclass) polymorphism.
- (WIP) the DAML example explores the subtyping relationship between `interfaces` and `templates`, how functorial variances can be useful in a language without implicit subtype conversion, ala Scala FP libraries like Cats.
