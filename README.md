Web Application - SimpleTwit:

REST Urls exposed:

1) Create User in app
<deployed context path>/SimpleTwit/account/createAccount/{userName}/{userId}/{password}

2) Delete user from app
<deployed context path>/SimpleTwit/account/deleteAccount/{userId}

3) Twit from a user account
<deployed context path>/SimpleTwit/twit/add/{userId}/{twit}

4) get twits for a particular user
<deployed context path>/SimpleTwit/twit/getTwits/{userId}
This is just a basic application.

Subscription part:

Exposed url:
<deployed context path>/SimpleTwit/AppDirect/event/{eventUrl}

->Integration not complete
->Methods implemented:
1)Subscription order
2)Subscription cancel
->No db storage handling taken
