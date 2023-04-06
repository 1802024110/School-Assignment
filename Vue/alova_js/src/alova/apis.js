import {alovaInstance} from "@/alova/index";

const todoHitokotoGetter = alovaInstance.Get("/hitokoto",{
    headers:{
        'Content-Type': 'application/json;charset=UTF-8'
    }
})

export {
    todoHitokotoGetter
}