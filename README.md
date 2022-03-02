# SC-DeliveryPromise
Promise System

## Modules
### promise-core
//TODO

### promise-ccs

## 1. How to Do Code Review
* Make changes on local branch
* Push to remote branch (this might be in a fork of the repo, or the main repo)
* Create a merge/pull request to merge your branch into master
* Wait for review
* Fix review comments and push up additional commits to the remote branch.
* Finally, branch is merged to master (or wherever) as a sequence of commits (usually with a merge commit).

## 2. How to Check Code Coverage Rate with Jacoco
Build service, then the code coverage report will be generated in: __~/SC-DeliveryPromise/target/site/jacoco__
```shell
~/SC-DeliveryPromise$ mvn clean package
```

## Reference
* [Connect to GitHub with SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)
* [Difference between Github and Gerrit](https://www.quora.com/What-is-the-main-difference-between-GitHub-and-Gerrit)
* [JaCoCo](https://www.jacoco.org/jacoco)