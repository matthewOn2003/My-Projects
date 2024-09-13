const express = require('express');
const cors = require('cors');
const app = express();
const PORT = process.env.PORT || 9000;


// app use
app.use(cors());
app.use(express.json());


// Routes
const userRoute = require('./routes/userRoutes');
// const blogRoute = require('./route/blogRoutes');
// ...



// Use Routes 
app.use('/users', userRoute);
// app.use('/blogs', blogRoute);
// ...



app.listen(PORT, () => {
    console.log(`wawaServer running on port ${PORT}`);
});
