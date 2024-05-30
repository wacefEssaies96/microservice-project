# Use an official Node.js runtime as a parent image
FROM node:14

# Set the working directory
WORKDIR /chat

# Copy package.json and package-lock.json to the container
COPY package*.json ./

# Install application dependencies
RUN npm install

# Bundle app source code
COPY . .

# Expose the application port
EXPOSE 3000

# Define the command to run your application
CMD [ "node", "server.js" ]
