import {createAlova} from "alova";
import VueHook from "alova/vue";
import GlobalFetch from "alova/GlobalFetch";
const alovaInstance = createAlova({
    baseURL:" /wrdan",
    statesHook:VueHook,
    requestAdapter: GlobalFetch(),
    responsed: (response) => response.json(),
})

export {
    alovaInstance
}