---
name: Read this before submitting an issue
about: General purpose template that will guide you through effectively submitting an issue about GraalVM
title: ''
labels: ''
assignees: ''
---

```
NB! Switch to the preview mode using the button above for better readability of the instructions.
```

Issues are at the heart of any open source project collaboration. Thank you for submitting an issue and making GraalVM the best it can be.

**Reporting issues**
First of all, GraalVM is a large project and spans a few repositories, if your issue is related to the components in other repositories, please consider raising it there:
* [oracle/graal](https://github.com/oracle/graal) - GraalVM SDK, GraalVM compiler, Truffle framework, GraalVM native images, LLVM interpreter, WebAssembly support, tooling, regexp engine, GraalVM distribution, VS Code extensions.
* [graalvm/graaljs](https://github.com/graalvm/graaljs) - GraalVM's JavaScript engine, node.js integration
* [graalvm/graalpython](https://github.com/graalvm/graalpython) - GraalVM's Python implementation
* [oracle/fastR](https://github.com/oracle/fastr) - GraalVM's R implementation
* [oracle/truffleruby](https://github.com/oracle/truffleruby) - GraalVM's Ruby implementation: TruffleRuby

If this issue belongs to this repository, please mark it with the relevant component: `compiler`, `native-image`, etc.

Please **do not** report security vulnerabilities as issues. Report a security vulnerability to secalert_us@oracle.com. For additional information see [Reporting Vulnerabilities guide](https://www.oracle.com/corporate/security-practices/assurance/vulnerability/reporting.html).

There are different types of issues and they are a little bit different, please help us work effectively and triage your issue into what category it is. If you don't know what it is,
don't get discouraged and submit whatever information you have.

**Questions**

If you have a question about a certain feature, lack of thereof, roadmap, support for new languages and so on, these are allowed as issues, but please title the issue with `[question]`, use the label `question` and elaborate your question in detail.
If you doubt whether your question is worth creating an issue for posterity, please ask it in the GraalVM community slack first: [GraalVM slack](https://www.graalvm.org/slack-invitation).

**Reporting problems**

When you report an issue please include relevant information about the issue:
* Description of the issue -- what went wrong.
* Environment: Operating system, architecture, cloud provider, whether docker is involved, etc.
* GraalVM version and build (for example is it a jdk8 or jdk11 based build).
* What were you trying to achieve when encountered the issue?
* What commands did you run?
* What was the expected output?
* What was the actual output?
* If you know, please label the issue with the relevant component: `compiler`, `native-image`, etc.

To help fixing the issue please consider adding the following details:
* How to reproduce? Is there a sample program we can try running, maybe a small project?
  * Please include the steps to reproduce too, how to build the project, what to run.
* Include all the logs you can gather (if applicable):
  * hs_err_PID.log files in case of crashes
  * `native-image` output for generating the binary
  * runtime output of your code
* If you're reporting a performance issue, please consider gathering the [JFR information about the run](https://docs.oracle.com/javacomponents/jmc-5-4/jfr-runtime-guide/about.htm#JFRUH170).
  * Consider including a JFR log for running on GraalVM and maybe on another JDK for comparison.
* If it's an issue with Java or JVM languages, did you try running on another JDK or with the `-XX:-UseJVMCICompiler` option to check if it's an issue specific to the GraalVM compiler.


**Feature request**

If you'd like to request a feature and maybe even collaborate on implementing it, please include the following information:

* *Is your feature request related to a problem? Please describe.*
A clear and concise description of what the problem is. Ex. I'm always frustrated when [...]

* *Describe the solution you'd like.*
A clear and concise description of what you want to happen.

* *Describe who do you think will benefit the most.*
GraalVM users, GraalVM contributors, developers of libraries and frameworks which depend on GraalVM, or somebody else?

* *Describe alternatives you've considered.*
A clear and concise description of any alternative solutions or features you've considered.

* *Additional context.*
Add any other context about the feature request here.
For example, link to the relevant projects, documentation, standards.

* *Express whether you'd like to help contributing this feature*
If you'd like to contribute, please read the [contribution guide](https://www.graalvm.org/community/contributors/).

Please label your issue with `feature`.
