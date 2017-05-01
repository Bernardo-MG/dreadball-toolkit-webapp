import React from 'react';
//import { Table } from 'react-toolbox';
import { injectIntl } from 'react-intl';
import unitMessages from 'i18n/unit';

class UnitOptionTable extends React.Component {
   UnitModel = {}
   
   constructor(props) {
      super(props);
      this.UnitModel = {
         name: {type: String, title: props.intl.formatMessage(unitMessages.name)},
         role: {type: String, title: props.intl.formatMessage(unitMessages.role)},
         cost: {type: Number, title: props.intl.formatMessage(unitMessages.cost)}
      };
   }  
   
   render() {
      return (
         <div/>
         //<Table
         //   model={this.UnitModel}
         //   source={this.props.source}
         //   selectable={false}
         //   multiSelectable={false} />
      );
   };
};

export default injectIntl(UnitOptionTable);