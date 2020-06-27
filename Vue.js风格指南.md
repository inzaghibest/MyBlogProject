# Vue.js风格指南

## 1. 组件名为多个单词

**组件名应该始终是多个单词的，根组件 `App` 以及 `<transition>`、`<component>` 之类的 Vue 内置组件除外。**

这样做可以避免跟现有的以及未来的 HTML 元素[相冲突](https://w3c.github.io/webcomponents/spec/custom/#valid-custom-element-name)，因为所有的 HTML 元素名称都是单个单词的。

#### 反例

```vue
Vue.component('todo', {
  // ...
})
export default {
  name: 'Todo',
  // ...
}
```

#### 好例子

```vue
Vue.component('todo-item', {
  // ...
})
export default {
  name: 'TodoItem',
  // ...
}
```