// Load required packages
var express = require('express');
var mongoose = require('mongoose');
var bodyParser = require('body-parser');
var Cheese = require('./models/cheese');

// Connect to the cheeselocker MongoDB
mongoose.connect('mongodb://localhost:27017/cheeselocker');

// Create our Express application
var app = express();

// Use the body-parser package in our application
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
  extended: true
}));

// Use environment defined port or 3000
var port = process.env.PORT || 3000;

// Create our Express router
var router = express.Router();

// Initial dummy route for testing http://localhost:3000/api
router.get('/', function(req, res) {
  res.json({ message: 'You are running dangerously low on cheese Gromit!' }); 
});

// Create a new route with the prefix /cheeses
var cheesesRoute = router.route('/cheeses');

// Create endpoint /api/cheeses for POSTS
cheesesRoute.post(function(req, res) {
  // Create a new instance of the cheese model
  var cheese = new Cheese();

  // Set the cheese properties that came from the POST data
  cheese.name = req.body.name;
  cheese.strength = req.body.strength;
  cheese.quantity = req.body.quantity;

  // Save the cheese and check for errors
  cheese.save(function(err) {
    if (err)
      res.send(err);

    res.json({ message: 'cheese added to the locker!', data: cheese });
    console.log(cheese);
  });
});

// Create endpoint /api/cheeses for GET
cheesesRoute.get(function(req, res) {
  // Use the cheese model to find all cheese
  cheese.find(function(err, cheeses) {
    if (err)
      res.send(err);

    res.json(cheeses);
  });
});

// Create a new route with the /cheeses/:cheese_id prefix
var cheeseRoute = router.route('/cheeses/:cheese_id');

// Create endpoint /api/cheeses/:cheese_id for GET
cheeseRoute.get(function(req, res) {
  // Use the cheese model to find a specific cheese
  cheese.findById(req.params.cheese_id, function(err, cheese) {
    if (err)
      res.send(err);

    res.json(cheese);
  });
});

// Create endpoint /api/cheeses/:cheese_id for PUT
cheeseRoute.put(function(req, res) {
  // Use the cheese model to find a specific cheese
  cheese.findById(req.params.cheese_id, function(err, cheese) {
    if (err)
      res.send(err);

    // Update the existing cheese quantity
    cheese.quantity = req.body.quantity;

    // Save the cheese and check for errors
    cheese.save(function(err) {
      if (err)
        res.send(err);

      res.json(cheese);
    });
  });
});

// Create endpoint /api/cheeses/:cheese_id for DELETE
cheeseRoute.delete(function(req, res) {
  // Use the cheese model to find a specific cheese and remove it
  cheese.findByIdAndRemove(req.params.cheese_id, function(err) {
    if (err)
      res.send(err);

    res.json({ message: 'cheese removed from the locker!' });
  });
});

// Register all our routes with /api
app.use('/api', router);

// Start the server
app.listen(port);
console.log('Running on port ' + port);