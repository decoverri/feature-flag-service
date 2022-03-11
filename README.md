# Feature Flag Service

API to create features and enable/disable them globally or for user.
Abstract concept, not really an app.

Post request to add feature require header `userType = admin` and body in the format below:
```
{
  "feature-name": "<name of you feature>"
}
```

Put request to enable/disable require header `userType = admin`

Get request to see enabled features for user require header `userId = <number>`

There are only two users (ids 0 and 1)

There is no error handling for no existent ids. Would be next feature after tests and swagger docs.
