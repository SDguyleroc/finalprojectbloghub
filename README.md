# Group 3 FinalProject
Ossebi Guy-Lero and Nirav Patel

## Introduction
Our project aims to develop a web application called "Blogger's Hub" that provides a platform for bloggers to create, publish, and share their content with readers. The application will offer a user-friendly interface for both writers and readers, fostering a community where bloggers can engage with their audience and grow their following. 

## Story Board
![StoryBoard](https://github.com/patel6nr/Group3FinalProject/assets/122308867/c9d79d32-4251-4b25-ad7c-12f7d1985363)

## Requirements
 
**1. Creating and Publishing Blog Posts**: As a User, I want to create and publish blog posts so that I can share my thoughts and ideas with others.
   
**Given**: The user is logged in to the Blogger's Hub platform.

**When**: The user navigates to the "Create New Post" page and fills out the required fields.

**Then**: The user's blog post is published and made visible to readers. 

**2. Categorizing Blog Posts**: As a User, I want to categorize my blog posts so that I can organize my content effectively. 

**Given**: The user is creating a new blog post.

**When**: The user selects one or more categories for the post. 

**Then**: The post is tagged with the selected categories. 

**3. Interacting with Other Bloggers and Readers**: As a User, I want to interact with other bloggers and readers so that I can build a 	community around my blog. 

**Given**: The user is viewing a blog post. 

**When**: The user leaves a comment on the post.

**Then**: The comment is displayed on the post and other users can respond to it. 

## Class Diagram
![StoryBoard](https://github.com/patel6nr/Group3FinalProject/assets/122308867/22f75fe5-e43e-411f-bd4b-91e01be0098a) 
### Class Diagram Description 
The class diagram shows how a user can create his/her own blog. The user can also view blogs posted by other users and also comment, like and share the blog.
Bloggers Hub also allows the user to filter blogs using category, tag and date posted.

JSON Schema
This is what we plan to export to another app.

{ "type": "object", "properties": { "postId": { "type": "integer" }, "title": { "type": "string" }, "content": { "type": "string" }, "author": { "type": "string" }, "categories": { "type": "array", "items": { "type": "string" } },

"comments": { "type": "array", "items": { "type": "object", "properties": { "commentId": { "type": "integer" }, "content": { "type": "string" }, "author": { "type": "string" } }

## Milestones
### Milestone #1: Basic Functionality

**Set up Project Repository**:
- Initialize version control system (e.g., Git) repository.
- Choose a hosting platform (e.g., GitHub, GitLab, Bitbucket) and set up the repository.
  
**Design Database Schema for Blog Posts**:
- Define the structure of the database tables for storing blog post data (e.g., title, content, author, categories, comments).
- Choose appropriate data types and relationships between tables.
  
**Create User Authentication System**:
- Develop a system for user registration, login, and logout.
- Implement password hashing and user session management for security.
  
**Implement Basic Functionality for Blog Posts**:
- Create endpoints/routes for creating, reading, updating, and deleting blog posts.
- Implement CRUD (Create, Read, Update, Delete) operations for blog posts.
  
**Develop User Interface for Posting Blogs**:
- Design and develop a user-friendly interface for creating and editing blog posts.
- Include form fields for title, content, categories, and any other relevant metadata.
  
**Design a Homepage to Display Recent Blog Posts**:
- Create a homepage layout that showcases recent blog posts.
- Include features like pagination, sorting, and filtering options.
  
**Write Basic Tests for Functionality**:
- Develop automated tests to verify the functionality of key features like user authentication, blog post creation, and data retrieval.
- Write unit tests, integration tests, and end-to-end tests as appropriate.
  
### Milestone #2: Enhanced Features

**Implement Rich Text Editor**: 
- Enhance the blog post creation interface with a rich text editor for formatting options like bold, italic, headings, etc.
  
**Add Image Upload Capability**:
- Allow users to upload images to accompany their blog posts.
  
**Integrate SEO Tools**:
- Incorporate tools to optimize blog posts for search engines, including meta tags, keywords, and descriptions.
  
**Implement User Profiles**:
- Enable users to create profiles with bio, profile pictures, and social media links.
  
**Add Draft Saving Feature**:
- Allow users to save blog posts as drafts to work on them later before publishing.
  
**Enhance Commenting System**:
- Implement features like threaded comments, upvoting/downvoting, and comment moderation.
  
**Integrate Analytics**:
- Add analytics to track blog post views, user engagement, and traffic sources.
  
### Milestone #3: Social Features

**Implement User Following**:
- Allow users to follow their favorite bloggers to receive notifications about new posts.
  
**Add Social Sharing Buttons**: 
- Include buttons for easy sharing of blog posts on social media platforms.
  
**Enhance User Interaction**: 
- Introduce features like direct messaging between users and tagging other users in comments.
  
**Implement Notifications**: 
- Notify users about new comments, likes, and follows related to their posts.
  
**Integrate Social Login**:
- Enable users to sign in/register using social media accounts for easier onboarding.
  
**Develop Explore Page**:
- Create a page where users can discover new blogs based on categories, tags, and trending topics.\
  
**Enhance User Engagement**:
- Implement features like polls, quizzes, and surveys to engage users and gather feedback.

## Team Members and Roles
**UI Specialist / Business Logic / Persistence / DevOps / Product Owner / Scrum Master / GitHub Admin**:
Ossebi Guy-Lero and Nirav Patel

**Team Meeting**:
Every Sunday evening Between 6 pm to 8 pm
