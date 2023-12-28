// AuthorDisplay.jsx

import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import axios from 'axios';
import { toast } from 'react-toastify'; // Import react-toastify
import 'react-toastify/dist/ReactToastify.css'; // Import the CSS for react-toastify
import './Author.css';

const AuthorDisplay = () => {
  const location = useLocation();
  const authorId = location.state.authorId;
  const [posts, setPosts] = useState([]);
  const [selectedPostId, setSelectedPostId] = useState(null);
  const [isUpdating, setIsUpdating] = useState(false);
  const [updatedData, setUpdatedData] = useState({
    authorId: '',
    title: '',
    content: '',
  });
  const [newPostData, setNewPostData] = useState({
    authorId: '',
    title: '',
    content: '',
    createdAt: '',
  });
  const [showAddForm, setShowAddForm] = useState(false);

  useEffect(() => {
    const fetchPosts = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/posts/author/${authorId}`);
        setPosts(response.data);
      } catch (error) {
        console.error('Error fetching posts:', error);
      }
    };

    if (authorId) {
      fetchPosts();
    }
  }, [authorId]);

  const handleDelete = async (postId) => {
    try {
      const confirmDelete = window.confirm("Are you sure you want to delete this post?");
    if (!confirmDelete) {
      return; // Do nothing if the user cancels the deletion
    }
      await axios.delete(`http://localhost:8080/comments/del/${postId}`);
      await axios.delete(`http://localhost:8080/api/posts/${postId}`);
      setPosts(posts.filter((post) => post.id !== postId));
      // Notify success after deletion
      toast.success('Post deleted successfully', {
        position: 'top-center',
        autoClose: 2000,
        hideProgressBar: false,
        closeOnClick: true,
        style: {
          fontSize: '16px',
          padding: '16px',
          whiteSpace: 'nowrap'
        },
      });
    } catch (error) {
      console.error('Error deleting post:', error);
    }
  };

  const handleUpdate = (postId) => {
    setSelectedPostId(postId);
    setIsUpdating(true);
    const postToUpdate = posts.find((post) => post.id === postId);
    setUpdatedData({
      authorId: postToUpdate.authorId,
      title: postToUpdate.title,
      content: postToUpdate.content,
    });
  };

  const submitUpdate = async () => {
    try {
      if (updatedData.authorId && updatedData.title && updatedData.content) {
        const response = await axios.put(`http://localhost:8080/api/posts/${selectedPostId}`, updatedData);
        setPosts(posts.map((post) => (post.id === selectedPostId ? response.data : post)));
        setIsUpdating(false);
        setSelectedPostId(null);
        setUpdatedData({
          authorId: '',
          title: '',
          content: '',
        });
        // Notify success after update
        toast.success('Post updated successfully', {
          position: 'top-center',
          autoClose: 2000,
          hideProgressBar: false,
          closeOnClick: true,
          style: {
            fontSize: '16px',
            padding: '16px',
            whiteSpace: 'nowrap'
          },
        });
      } else {
        console.error('Please fill in all required fields for update.');
      }
    } catch (error) {
      console.error('Error updating post:', error);
    }
  };

  const handleAdd = async () => {
    setShowAddForm(true);
  };

  const submitAdd = async () => {
    try {
      if (newPostData.authorId && newPostData.title && newPostData.content && newPostData.createdAt) {
        const response = await axios.post(`http://localhost:8080/api/posts/create`, newPostData);
        setPosts([...posts, response.data]);
        setNewPostData({
          authorId: '',
          title: '',
          content: '',
          createdAt: '',
        });
        setShowAddForm(false);
        // Notify success after adding
        toast.success('Post added successfully', {
          position: 'top-center',
          autoClose: 2000,
          hideProgressBar: false,
          closeOnClick: true,
          style: {
            fontSize: '16px',
            padding: '16px',
            whiteSpace: 'nowrap'
          },
        });
      } else {
        console.error('Please fill in all required fields for new post.');
      }
    } catch (error) {
      console.error('Error adding post:', error);
    }
  };
  return (
    <div className="scroll-container">
      <center><h1>Posts by Author {authorId}</h1></center>
      {posts.map((post, index) => (
        <div key={post.id}>
          <h2><font size="10px" color="black" face="arial">{post.title}</font></h2>
          <pre><font size="15px" face="arial">{post.content}</font></pre>
          <button onClick={() => handleDelete(post.id)}>Delete</button>
          <button onClick={() => handleUpdate(post.id)}>Update</button>
          {isUpdating && selectedPostId === post.id && (
            <div class="post-update">
              <form>
                <center><h2>Update Post</h2></center>
              <div>
              <label>Author ID:  </label>
              <input
                type="text"
                placeholder="Author ID"
                required
                value={updatedData.authorId}
                onChange={(e) => setUpdatedData({ ...updatedData, authorId: e.target.value })}
              />
              </div>
              <div>
              <label>Update Title:</label>
              <input
                type="text"
                placeholder="Updated Title"
                value={updatedData.title}
                required
                onChange={(e) => setUpdatedData({ ...updatedData, title: e.target.value })}
              />
              </div>
              <div>
              <label>Update Content:</label>
              <textarea
                placeholder="Updated Content"
                value={updatedData.content}
                required
                onChange={(e) => setUpdatedData({ ...updatedData, content: e.target.value })}
              />
              </div>
              <button onClick={submitUpdate}>Submit Update</button>
              </form>
            </div>
          )}
          {/* Add <hr> tag between posts, except for the last one */}
          {index !== posts.length  && <hr />}
        </div>
      ))}
      {showAddForm && (
  <div className="add-post">
  <center><h2>Add Post</h2></center>
  <form>
  <div>
    <label>Author ID: </label>
    <input
      type="text"
      placeholder="Author ID"
      required
      value={newPostData.authorId}
      onChange={(e) => setNewPostData({ ...newPostData, authorId: e.target.value })}
    />
  </div>
  <div>
  <label>Title: </label>
    <input
      type="text"
      placeholder="Title"
      required
      value={newPostData.title}
      onChange={(e) => setNewPostData({ ...newPostData, title: e.target.value })}
    />
  </div>
  <div>
  <label>Content: </label>
    <textarea
      placeholder="Content"
      required
      value={newPostData.content}
      onChange={(e) => setNewPostData({ ...newPostData, content: e.target.value })}
    />
  </div>
  <div>
  <label>Created At: </label>
    <input
      type="text"
      placeholder="Created At"
      required
      value={newPostData.createdAt}
      onChange={(e) => setNewPostData({ ...newPostData, createdAt: e.target.value })}
     
    />
  </div>
  <div>
    <center><button onClick={submitAdd}>Submit Post</button></center>
  </div>
  </form>
</div>

      )}
      {!showAddForm && (
        <div>
          <button onClick={handleAdd}>Add Post</button>
        </div>
      )}
    </div>
  );
};

export default AuthorDisplay;
