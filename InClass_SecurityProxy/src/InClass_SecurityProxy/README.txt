Look at the Client code.
Note how Trudy hacks into her account and adds some money.

1. Create a read-only proxy for the account class.
This should throw a security exception if a write is attempted.

2. Edit the Bank code to create a read-only proxy of Trudy's account before passing it to the
ClientPlugin.

The TODOs about lambdas and DecimalFormat are optional. Please do those last only if you have time.
