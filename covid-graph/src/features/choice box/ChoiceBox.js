import React from 'react';
import Select from 'react-select';
import Proptypes from 'prop-types';
import ISO3ToFlag from '../../ISO3ToFlag.json';

const ChoiceBox = ({countries, onChange}) => {
    const options = Object.keys(countries).map(
        country => {
            const iso3 = countries[country];
            return ({
                value: {country}, 
                label: `${ISO3ToFlag[iso3 ? iso3 : ""]} ${country}`
            })
        }
    )
    return (
        <Select options={options} onChange={onChange}/>
    );
}

ChoiceBox.propTypes = {
    countries: Proptypes.objectOf(Proptypes.string).isRequired,
    onChange: Proptypes.func,
}

export default ChoiceBox;