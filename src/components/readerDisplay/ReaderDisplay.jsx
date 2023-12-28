import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Reader.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faComment } from '@fortawesome/free-solid-svg-icons';

const ReaderDisplay = ({ readerId }) => {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [commentFormPostId, setCommentFormPostId] = useState(null);
  const [commentData, setCommentData] = useState({ readerId: '', commentContent: '' });

  const fetchData = async () => {
    try {
      const postsResponse = await axios.get('http://localhost:8080/api/posts/posts');
      const postsData = postsResponse.data;

      const postsWithComments = await Promise.all(
        postsData.map(async (post) => {
          const authorResponse = await axios.get(`http://localhost:8080/api/authors`);
          const author = authorResponse.data;

          const commentsResponse = await axios.get(`http://localhost:8080/comments/post/${post.id}`);
          const comments = commentsResponse.data;

          return { ...post, author, comments };
        })
      );

      setPosts(postsWithComments);
      setLoading(false);
    } catch (error) {
      console.error('Error fetching data:', error);
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  const handleCommentFormChange = (e) => {
    setCommentData((prevData) => ({ ...prevData, [e.target.name]: e.target.value }));
  };

  const handleAddComment = async (postId) => {
    try {
      if (!commentData.readerId || !commentData.commentContent) {
        // Check if both readerId and commentContent are provided
        console.error('Please provide both Reader ID and Comment Content.');
        return;
      }

      const response = await axios.post(`http://localhost:8080/comments/post`, {
        ...commentData,
        post: { id: postId }, // Include postId in the request body
      });

      // Log the added comment for debugging
      console.log('Comment Added:', response.data);
      fetchData();
      setCommentData({ readerId: '', commentContent: '' });
      setCommentFormPostId(false);

    } catch (error) {
      console.error('Error adding comment:', error);
    }
  };
  const renderPostsWithComments = () => {
    return posts.map((post) => (
      <div key={post.id}>
        <h2>{post.title}</h2>
        {post.author && <p><font color="red">Author ID: {post.authorId}</font></p>}
        <pre><font color="black">{post.content}</font></pre>
        <div>
          <button onClick={() => setCommentFormPostId(post.id)}>
            <FontAwesomeIcon icon={faComment}  size="2x"/> Add Comment
          </button>
          {commentFormPostId === post.id && (
           
            <div className="add-comment">
              <center><h2>Add Comment:</h2></center>
              <form onSubmit={(e) => e.preventDefault()}>
                <label>
                  Reader ID:
                  <input
                    type="text"
                    name="readerId"
                    required
                    placeholder='Enter ReaderId'
                    value={commentData.readerId}
                    onChange={handleCommentFormChange}
                  />
                </label>
                <label>
                  Comment Content:
                  <textarea
                    name="commentContent"
                    required
                    placeholder='Write your comment here...!!!!'
                    value={commentData.commentContent}
                    onChange={handleCommentFormChange}
                  />
                </label>
                <label>
                  <center><button type="button" onClick={() => handleAddComment(post.id)}>
                    Submit Comment
                  </button></center>
                </label>
                </form>
            </div>
          )}
          <h2>Comments:</h2>
          {Array.isArray(post.comments) && post.comments.length > 0 ? (
            post.comments.map((comment) => (
              <div key={comment.id}>
                <p><font color="red">{comment.readerId} posted the comment on this post:</font></p>
                <pre><font color="black">{comment.commentContent}</font></pre>
                
                
              </div>
            ))
          ) : (
            <p><font color="black">No comments available.</font></p>
          )}
        </div>
        <hr />
      </div>
    ));
  };

  return (
    <div className="scroll-container">
      <h1>EDUTECH CONTENT </h1>
      {loading ? <p>Loading...</p> : renderPostsWithComments()}
    </div>
  );
};

export default ReaderDisplay;