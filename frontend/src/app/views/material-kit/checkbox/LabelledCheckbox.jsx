import CheckBoxIcon from '@mui/icons-material/CheckBox';
import CheckBoxOutlineBlankIcon from '@mui/icons-material/CheckBoxOutlineBlank';
import Favorite from '@mui/icons-material/Favorite';
import FavoriteBorder from '@mui/icons-material/FavoriteBorder';
import { styled } from '@mui/material';
import Checkbox from '@mui/material/Checkbox';
import { green } from '@mui/material/colors';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormGroup from '@mui/material/FormGroup';
import React from 'react';

const GreenCheckbox = styled(Checkbox)(() => ({
  color: green[400],
  '&$checked': {
    color: green[600],
  },
}));

export default function LabelledCheckbox() {
  const [state, setState] = React.useState({
    checkedA: true,
    checkedB: true,
    checkedF: true,
    checkedG: true,
  });

  const handleChange = (name) => (event) => {
    setState({ ...state, [name]: event.target.checked });
  };

  return (
    <FormGroup row>
      <FormControlLabel
        control={
          <Checkbox checked={state.checkedA} onChange={handleChange('checkedA')} value="checkedA" />
        }
        label="Secondary"
      />
      <FormControlLabel
        control={
          <Checkbox
            checked={state.checkedB}
            onChange={handleChange('checkedB')}
            value="checkedB"
            color="primary"
          />
        }
        label="Primary"
      />
      <FormControlLabel control={<Checkbox value="checkedC" />} label="Uncontrolled" />
      <FormControlLabel disabled control={<Checkbox value="checkedD" />} label="Disabled" />
      <FormControlLabel disabled control={<Checkbox checked value="checkedE" />} label="Disabled" />
      <FormControlLabel
        control={
          <Checkbox
            checked={state.checkedF}
            onChange={handleChange('checkedF')}
            value="checkedF"
            indeterminate
          />
        }
        label="Indeterminate"
      />
      <FormControlLabel
        control={
          <GreenCheckbox
            color="default"
            checked={state.checkedG}
            onChange={handleChange('checkedG')}
            value="checkedG"
          />
        }
        label="Custom color"
      />
      <FormControlLabel
        control={<Checkbox icon={<FavoriteBorder />} checkedIcon={<Favorite />} value="checkedH" />}
        label="Custom icon"
      />
      <FormControlLabel
        control={
          <Checkbox
            icon={<CheckBoxOutlineBlankIcon fontSize="small" />}
            checkedIcon={<CheckBoxIcon fontSize="small" />}
            value="checkedI"
          />
        }
        label="Custom size"
      />
    </FormGroup>
  );
}
