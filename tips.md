# NPM
When you create a new project/homework
~~~shell
npm init
npm install [library name]
npm install express
~~~

# Node js
When you run/test your code
~~~shell
node [js script]
node main.js
~~~

# Package.json
After you init with NPM, you need to modify the package.json becuase you may want a unit test
~~~json
  "scripts": {
    "start": "node index.js",
    "test": "jest"
  },
~~~
~~~shell
npm start
npm run start
npm run test
~~~