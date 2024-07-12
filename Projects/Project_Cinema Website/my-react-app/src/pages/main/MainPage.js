import DarkNav from '../../components/DarkNav'
import BlackFooter from '../../components/BlackFooter'


import Recommendation from './Recommendation'
import Movies from './Movies'
import Top10 from './Top10'
import Promotions from './Promotions'

import test_backend from '../../test_backend';



function Main() {

    return (
        <div className="Main">
            <button onClick={test_backend}>test</button>

            <Recommendation />
            <Movies />
            <Top10 />
            <Promotions />
        </div>
    );
}

export default Main;
