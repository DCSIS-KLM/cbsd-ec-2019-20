// Load required packages
var mongoose = require('mongoose');

// Define our beer schema
var CheeseSchema   = new mongoose.Schema({
  name: String,
  strength: String,
  quantity: Number
});

// Export the Mongoose model
module.exports = mongoose.model('Cheese', CheeseSchema);