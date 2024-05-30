const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const Message = require('./models/message');

const app = express();
const port = 3000;

// Connect to MongoDB using your MongoDB Atlas URL
mongoose.connect("mongodb+srv://hammamiemna22:Xrfl9frzt5Nmsba5@chat0.xiqlfnj.mongodb.net/your-database-name", {
  useNewUrlParser: true,
  useUnifiedTopology: true,
}).then(() => {
  console.log("MongoDB is connected");
}).catch((error) => {
  console.error("MongoDB connection error: ", error);
  process.exit(1); // Exit the application on connection error
});

app.use(bodyParser.json());

// Create a new message
app.post('/messages', async (req, res) => {
  try {
    const message = new Message(req.body);
    await message.save();
    res.status(201).json(message);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Get all messages
app.get('/messages', async (req, res) => {
  const messages = await Message.find();
  res.json(messages);
});

// Update a message by ID
app.put('/messages/:id', async (req, res) => {
  try {
    const message = await Message.findByIdAndUpdate(req.params.id, req.body, { new: true });
    res.json(message);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Delete a message by ID
app.delete('/messages/:id', async (req, res) => {
  await Message.findByIdAndRemove(req.params.id);
  res.sendStatus(204);
});

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
