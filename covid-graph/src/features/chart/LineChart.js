import React from 'react';
import { Line } from 'react-chartjs-2';
import 'chartjs-plugin-zoom';
import Proptypes from 'prop-types';

const LineChart = ({data}) => {
    const dataForChart = {
        labels: [...Object.keys(data.cases)],
        datasets: [
            {
                label: 'Cases',
                data: [...Object.values(data.cases)],
                fill: false,
                backgroundColor: 'rgb(255, 35, 35)',
                borderColor: 'rgba(255, 35, 35, 0.5)',
            },
            {
                label: 'Deaths',
                data: [...Object.values(data.deaths)],
                fill: false,
                backgroundColor: 'rgb(0, 0, 0)',
                borderColor: 'rgba(0, 0, 0, 0.5)',
            },
        ]
    };
  
    const options = {scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true,
                min: Math.min(0, 
                    ...Object.values(data.cases), 
                    ...Object.values(data.deaths))
              },
            },
          ],
        },
        pan:{
            enabled: true,
            mode:'x'
        },
        zoom:{
            enabled:true,
            mode:'x'
        }
    };

    return (
        <Line data={dataForChart} options={options} />
    );
}

LineChart.propTypes = {
    data: Proptypes.shape({
        country: Proptypes.string.isRequired,
        cases: Proptypes.objectOf(Proptypes.number).isRequired,
        deaths: Proptypes.objectOf(Proptypes.number).isRequired,
    }),
}

export default LineChart;