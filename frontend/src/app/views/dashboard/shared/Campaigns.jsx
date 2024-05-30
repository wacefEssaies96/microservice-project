import { Box } from '@mui/material';
import { MatxProgressBar, SimpleCard } from 'app/components';
import { Small } from 'app/components/Typography';

const Campaigns = () => {
  return (
    <Box>
      <SimpleCard title="Campaigns">
        <Small color="text.secondary">Today</Small>
        <MatxProgressBar value={75} color="primary" text="Google (102k)" />
        <MatxProgressBar value={45} color="secondary" text="Twitter (40k)" />
        <MatxProgressBar value={75} color="primary" text="Tensor (80k)" />

        <Small color="text.secondary" display="block" pt={4}>
          Yesterday
        </Small>
        <MatxProgressBar value={75} color="primary" text="Google (102k)" />
        <MatxProgressBar value={45} color="secondary" text="Twitter (40k)" />
        <MatxProgressBar value={75} color="primary" text="Tensor (80k)" />

        <Small color="text.secondary" display="block" pt={4}>
          Yesterday
        </Small>
        <MatxProgressBar value={75} color="primary" text="Google (102k)" />
        <MatxProgressBar value={45} color="secondary" text="Twitter (40k)" />
        <MatxProgressBar value={75} color="primary" text="Tensor (80k)" />
      </SimpleCard>
    </Box>
  );
};

export default Campaigns;
