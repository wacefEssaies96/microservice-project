import React, { useState, useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import {
  Button,
  Grid,
  Icon,
  TextField,
  Card,
  CardContent,
  Typography,
} from "@mui/material";
import { ValidatorForm, TextValidator } from "react-material-ui-form-validator";
import { addComment, deleteComment, fetchComments, updateComment } from '../../../redux/actions/CommentAction';
import { Picker } from 'emoji-mart';

function SimpleForm() {
  const [contenu, setContenu] = useState('');
  const [error, setError] = useState(null);
  const [isEditing, setIsEditing] = useState(false);
  const [editedComment, setEditedComment] = useState({});
  const [showEmojiPicker, setShowEmojiPicker] = useState(false);
  const [selectedEmoji, setSelectedEmoji] = useState(null);

  const comments = useSelector((state) => state.commentReducer.comments);
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(fetchComments());
  }, [dispatch]);

  const handleEditClick = (comment) => {
    setIsEditing(true);
    setEditedComment(comment);
  };

  const handleDeleteClick = (commentId) => {
    dispatch(deleteComment(commentId));
  };

  const handleCommentChange = (event) => {
    setContenu(event.target.value);
    setError(null);
  };

  const toggleEmojiPicker = () => {
    setShowEmojiPicker(!showEmojiPicker);
  };

  const handleEmojiSelect = (emoji) => {
    setSelectedEmoji(emoji.native);
    toggleEmojiPicker();
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    const dateCreation = Date.now();
    const commentWithEmoji = selectedEmoji ? `${contenu} ${selectedEmoji}` : contenu;
    dispatch(addComment({ contenu: commentWithEmoji, dateCreation }));
    setContenu('');
    setSelectedEmoji(null); // Réinitialisez l'emoji sélectionné après l'ajout du commentaire
  };

  const handleUpdate = (event) => {
    event.preventDefault();
    dispatch(updateComment(editedComment));
    setIsEditing(false);
  };

  const cancelEdit = () => {
    setIsEditing(false);
  };

  return (
    <div>
      <ValidatorForm onSubmit={handleSubmit} onError={() => null}>
        <Grid container spacing={6}>
          <Grid item xs={12}>
            <TextValidator
              label="Commentaire"
              multiline
              rows={4}
              variant="outlined"
              fullWidth
              value={contenu}
              onChange={handleCommentChange}
              validators={['required']}
              errorMessages={['Ce champ est requis']}
            />
            <Button onClick={toggleEmojiPicker}>Ajouter un emoji</Button>
            {showEmojiPicker && (
              <Picker onSelect={handleEmojiSelect} />
            )}
          </Grid>
        </Grid>

        <Button color="primary" variant="contained" type="submit">
          <Icon>send</Icon>
          Submit
        </Button>
      </ValidatorForm>

      {error && <div style={{ color: 'red' }}>{error}</div>}

      <div>
        {comments.map((c) => (
          <Card key={c.id} style={{ marginBottom: '10px' }}>
            <CardContent>
              {isEditing && editedComment.id === c.id ? (
                // Formulaire de modification
                <form onSubmit={handleUpdate}>
                  <TextField
                    label="Modifier le commentaire"
                    multiline
                    rows={4}
                    variant="outlined"
                    fullWidth
                    value={editedComment.contenu}
                    onChange={(e) =>
                      setEditedComment({
                        ...editedComment,
                        contenu: e.target.value,
                      })
                    }
                  />
                  <Button color="primary" variant="contained" type="submit">
                    Modifier
                  </Button>
                  <Button onClick={() => cancelEdit()}>Annuler</Button>
                </form>
              ) : (
                // Affichage du commentaire
                <>
                  <Typography variant="body1">{c.contenu}</Typography>
                  <Typography variant="caption" color="textSecondary">
                    Date de création :{' '}
                    {new Date(c.dateCreation).toLocaleString()}
                  </Typography>
                  <Button onClick={() => handleEditClick(c)}>Modifier</Button>
                  <Button onClick={() => handleDeleteClick(c.id)}>Supprimer</Button>
                </>
              )}
            </CardContent>
          </Card>
        ))}
      </div>
    </div>
  );
}

export default SimpleForm;
