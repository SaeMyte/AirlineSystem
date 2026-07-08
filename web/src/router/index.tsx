import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import Chat from "../container/Chat";
import Home from "../container/Home";
import WebGenerationComp from "../container/WebGenerationComp";

const router = createBrowserRouter([{
    path:"/",
    element:<App/>,
    children:[
        {index:true, element:<Home />},
        {path:'chat', element:<Chat/>},
        {path:'web-dev', element:<WebGenerationComp/>},
    ]
}]);

export default router;